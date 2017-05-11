[![Download](https://api.bintray.com/packages/kkorolyov/groovy/auto-snapshot/images/download.svg) ](https://bintray.com/kkorolyov/groovy/auto-snapshot/_latestVersion)

# Auto SNAPSHOT
Suffixes a project's version with `-SNAPSHOT` if the latest git tag does not match the planned version.

## Usage
```groovy
buildscript {
	repositories {
		maven {
			url 'http://dl.bintray.com/kkorolyov/groovy'
		}
	}
	dependencies {
		classpath 'dev.kkorolyov:auto-snapshot:1.0'
	}
}
apply plugin: 'dev.kkorolyov.auto-snapshot'

```
1. Download the plugin from the Bintray repository
2. Apply it to your `build.gradle`

## License
[BSD-new license](LICENSE).  
