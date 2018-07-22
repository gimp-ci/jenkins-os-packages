# DEPRECATED

This project has been migrated to [GNOME GitLab under World/gimp-ci](https://gitlab.gnome.org/World/gimp-ci).  Refer to [the documentation repository for better information](https://gitlab.gnome.org/World/gimp-ci/documentation).  If you just want to build GIMP, then [check out the GIMP development environment based on Docker](https://gitlab.gnome.org/World/gimp-ci/docker-gimp).  The Docker environment also allows you to run GIMP if you have Xorg display; instructions therein.

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
