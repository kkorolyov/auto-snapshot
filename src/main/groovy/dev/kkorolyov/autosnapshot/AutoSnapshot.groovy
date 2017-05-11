package dev.kkorolyov.autosnapshot

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Suffixes the project version with '-SNAPSHOT' if a git tag matching the version set in the build script does not exist.
 */
class AutoSnapshot implements Plugin<Project> {
	void apply(Project project) {
		project.gradle.projectsEvaluated {
			def stdout = new ByteArrayOutputStream()
			project.exec {
				commandLine 'git', 'tag', '-l', "$project.version"
				standardOutput = stdout
			}

			if (project.version != stdout.toString().trim()) project.version = "$project.version-SNAPSHOT"	// Planned version does not have a tag
		}
	}
}
