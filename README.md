# Image Deletion Document

## Objective

* Record the actions(ID/owner/repository name/tag/remote addr/action time) of image operations including `pull, push and deletion` <br>
* Count the hit value of specific image actions <br>
* List the images to be delete according to specific settings(time of image keeping and image pull/push hits) <br>
* Run a crontab job of image deletion <br>
* Provide API to delete images, view image info(basic info, pull/push record, image action hits), inspect image deletion list <br>

# Design

* 