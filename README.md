# Image Deletion Document

## Objective

* Record the actions(ID/owner/repository name/tag/remote addr/action time) of image operations including `pull, push and deletion` 
* Count the hit value of specific image actions 
* List the images to be delete according to specific settings like `image keeping time, image pull/push hits`
* Run a `crontab job` of image deletion 
* Provide API to `delete images, view image info`(basic info, pull/push record, image action hits), `inspect image deletion list`

# Design

* 