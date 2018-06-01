/*
   Copyright (c) 2015-2018 Sam Gleske - https://github.com/samrocketman/jenkins-bootstrap-shared

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
   */
/*
   Schedules the first run of the seed job to generate jobs if it has not been
   run before.
 */

import jenkins.model.Jenkins

Jenkins.instance.getItemByFullName('_job_generator').with {
    if(it.nextBuildNumber == 1) {
        println 'Scheduling initial Seed Job.'
        it.scheduleBuild()
    }
    else {
        println 'Nothing changed.  Initial seed job already run.'
    }
}

null
