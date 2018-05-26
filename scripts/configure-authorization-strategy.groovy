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
   Configure authorization strategy for public READ access and admin-only
   logins.
 */

//import hudson.security.ProjectMatrixAuthorizationStrategy
import hudson.model.User
import hudson.security.GlobalMatrixAuthorizationStrategy
import jenkins.model.Jenkins

def installed_plugins = Jenkins.instance.pluginManager.plugins*.shortName
//configure the authorization strategy
def authz_strategy = new GlobalMatrixAuthorizationStrategy()
//set anonymous permissions
if('embeddable-build-status' in installed_plugins) {
    //only add permission if embeddable-build-status plugin is installed
    authz_strategy.add(this.class.classLoader.loadClass("org.jenkinsci.plugins.badge.PublicBadgeAction").VIEW_STATUS, 'anonymous')
}
//authz_strategy.add(Item.DISCOVER, 'anonymous')
authz_strategy.add(Item.READ, 'anonymous')
authz_strategy.add(Jenkins.READ, 'anonymous')
authz_strategy.add(View.READ, 'anonymous')
//Grant admin perms to authenticated users
authz_strategy.add(Jenkins.ADMINISTER, 'authenticated')
//Configure global authorization
Jenkins.instance.authorizationStrategy = authz_strategy
//save settings to persist across restarts
Jenkins.instance.save()
