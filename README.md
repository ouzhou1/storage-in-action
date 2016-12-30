Image Deletion Document
===

Objective
==

1. Record the actions(ID/owner/repository_name/tag/remote_addr/action_time) of image operations including pull, push and deletion
2. Count the hit value of specific image actions
3. List the images to be delete according to specific settings(time of image keeping and image pull/push hits)
4. Run a crontab job of image deletion
5. Provide API to delete images, view image info(basic info, pull/push record, image action hits), inspect image deletion list