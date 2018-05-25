#!/bin/bash
source jenkins-bootstrap-shared/jenkins_bootstrap.sh

create_view --view-name 'Status Overview' --xml-data ./configs/view_status_overview.xml
create_view --view-name 'Maintenance' --xml-data ./configs/view_maintenance.xml
create_view --view-name 'Build Pipelines' --xml-data ./configs/view_build_pipelines.xml
create_job --job-name '_job_generator' --xml-data ./configs/job_generator.xml
