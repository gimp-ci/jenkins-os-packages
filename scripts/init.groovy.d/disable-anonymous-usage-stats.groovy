/*
   Configure anonymous usage statistics to be disabled on startup.
 */
//disable submitting usage statistics for privacy
if(Jenkins.instance.isUsageStatisticsCollected()) {
    Jenkins.instance.setNoUsageStatistics(true)
    Jenkins.instance.save()
}
