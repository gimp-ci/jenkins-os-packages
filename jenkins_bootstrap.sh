#!/bin/bash
source jenkins-bootstrap-shared/jenkins_bootstrap.sh

create_view --view-name 'Status Overview' --xml-data ./configs/view_status_overview.xml
create_view --view-name 'Maintenance' --xml-data ./configs/view_maintenance.xml
create_view --view-name 'Build Pipelines' --xml-data ./configs/view_build_pipelines.xml
create_job --job-name '_job_generator' --xml-data ./configs/job_generator.xml
#disable job dsl script security
jenkins_console -s "${SCRIPT_LIBRARY_PATH}/configure-job-dsl-security.groovy"
#only enable JNLP4 agent protocol
jenkins_console -s "${SCRIPT_LIBRARY_PATH}/configure-jnlp-agent-protocols.groovy"
#global Jenkinsfile
jenkins_console -s "./scripts/configure-global-jenkinsfile-gimp.groovy"
#set markup formatter to HTML
jenkins_console -s "${SCRIPT_LIBRARY_PATH}/configure-markup-formatter.groovy"
#configure shared pipeline library
jenkins_console -s ./configs/shared-pipelines.groovy -s "${SCRIPT_LIBRARY_PATH}"/configure-pipeline-global-shared-libraries.groovy
#lockable resources for jobs
jenkins_console -s ./configs/lockable-resources.groovy -s "${SCRIPT_LIBRARY_PATH}"/configure-lockable-resources.groovy
#system settings such as domain name and system message
jenkins_console -s ./configs/system-settings.groovy -s "${SCRIPT_LIBRARY_PATH}"/configure-jenkins-settings.groovy
#set the default view
jenkins_console -s ./scripts/configure-default-view.groovy
#finally authorization to allow the public to view Jenkins
jenkins_console -s ./scripts/configure-authorization-strategy.groovy
#schedule initial seed job (only if it hasn't been run before)
jenkins_console -s ./scripts/schedule-seed-job.groovy
