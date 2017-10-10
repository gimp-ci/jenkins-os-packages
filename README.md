# jenkins-os-packages

Linux DEB and RPM system packages for [build.gimp.org](https://build.gimp.org/)
Jenkins.

# Why?

This is to support an immutable infrastructure model of Jenkins for the GIMP
project.  When installing Jenkins, it typically only installs the latest version
of the WAR and the latest version of all of the plugins.  This makes reliably
reproducing issues difficult.  Jenkins publishes artifacts to a [Maven
repository](https://repo.jenkins-ci.org/).  This project is designed to download
the exact version of the Jenkins WAR as well as exact versions of all of the
Jenkins plugins.  This makes configuring and testing upgrades more reliable.

# Building OS packages

See [packaging README](./packaging/README.md).

### License

* [Apache License 2.0](LICENSE)
