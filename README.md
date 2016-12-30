# Image Deletion Document

## Objective

* Record the actions(ID/owner/repository name/tag/remote addr/action time) of image operations including `pull, push and deletion` 
* Count the hit value of specific image actions 
* List the images to be delete according to specific settings like `image keeping time, image pull/push hits`
* Run a `crontab job` of image deletion 
* Provide API to `delete images, view image info`(basic info, pull/push record, image action hits), `inspect image deletion list`

## Design & Implement

* How to get image pulling&pushing logs \<br>
  We complish this via harbor ui container logs and nginx container logs
* How to determine the images to delete \<br>
  We firstly use image last pulling&pushing timestamp to `find the nonuse time`. 
  And we delete an image by `restricting the nonuse time and numbers of image pulling&pushing requests`