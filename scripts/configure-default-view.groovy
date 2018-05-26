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
   Sets the primary view of Jenkins.
 */

import hudson.model.View
import jenkins.model.Jenkins

Jenkins j = Jenkins.instance

default_view = 'Status Overview'

View desired_view = j.getView(default_view)
if(desired_view) {
    if(desired_view != j.primaryView) {
        j.primaryView = desired_view
        j.save()
        println "Primary view is now '${default_view}'."
    }
    else {
        println "Nothing changed.  Primary view is already '${default_view}'."
    }
}
else {
    println "ERROR: '${default_view}' does not exist as an available view."
}
