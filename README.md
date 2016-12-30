# Image Deletion Document

## Objective

* Record the infomation(ID/owner/repository/tag/remote addr/create time/pull&push time) of image operations including `pull and push` 
* Count the hit value of specific image pulls&pushes 
* List the images to be delete according to specific settings like `image keeping time, image pull/push hits`
* Run a `crontab job` of image deletion 
* Provide API to `delete images, view image info`(basic info, pull/push record, image action hits), `inspect image deletion list`

## Design & Implement

* How to get image pulling&pushing requests <br>
  First, we establish our own HTTP Server <br>
  Then, we modify the `nginx.conf` file in the `nginx container` to forward the pull&push requests to local server
* How to distinguish image pulls and image pushes <br>
  
* How to determine the images to delete <br>
  We firstly use image last pulling&pushing timestamp to `find the nonuse time`. 
  Then we delete an image by `restricting the nonuse time and numbers of image pulling&pushing requests`