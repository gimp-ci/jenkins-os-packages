system_message = '''
<!--
  style color schemes come from bootstrap alerts
  http://www.w3schools.com/bootstrap/bootstrap_alerts.asp
  success:
    background-color: #dff0d8;
    border: 1px solid #d6e9c6;
    color: #3c763d;
  info:
    background-color: #d9edf7;
    border: 1px solid #bce8f1;
    color: #31708f;
  warning:
    background-color: #fcf8e3;
    border: 1px solid #faebcc;
    color: #8a6d3b;
  danger:
    background-color: #f2dede;
    border: 1px solid #ebccd1;
    color: #a94442;
-->
<style>
  div#systemmessage {
    background-color: #dff0d8;
    border: 1px solid #d6e9c6;

    border-radius: 3px;
    margin-bottom: 10px;
    padding-left: 10px;
    padding-right: 10px;
  }
  div#systemmessage p {
    color: #3c763d;
  }
</style>
<p>
  <b>New and Improved:</b> welcome to a fresh re-design of
  <tt>build.gimp.org</tt>.  This re-design builds GIMP in a
  <a href="https://github.com/gimp-ci/docker-jenkins-gimp">Docker container</a>.  To see the new GIMP build pipelines click the "Open Blue Ocean" link in the menu to the left..
</p>
'''

master_settings = [
    system_message: system_message,
    frontend_url: 'https://build.gimp.org/',
    master_usage: 'normal'
]
