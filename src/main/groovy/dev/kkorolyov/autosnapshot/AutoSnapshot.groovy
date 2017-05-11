package dev.kkorolyov.autosnapshot

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Assigns the project version using "git describe" information.
 */
class AutoSnapshot implements Plugin<Project> {
	void apply(Project project) {
		project.version = {
			def stdout = new ByteArrayOutputStream()
			project.exec {
				commandLine 'git', 'describe', '--always', '--match', '*[0-9]\\.[0-9]*'
				standardOutput = stdout
			}
			def gitVersion = stdout.toString().trim().replaceFirst(/[+-].*/, '')

			if (version != gitVersion) version = "$version-SNAPSHOT"	// Planned version does not have a tag
		}()
	}
}
