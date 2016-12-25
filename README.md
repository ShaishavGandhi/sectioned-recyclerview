# Sectioned-RecyclerView
RecyclerView with support for sections, headers and adding miscellaneous views at any position.

## Use Case
There are often times when lists to display have complex underlying data beneath them. Take an example of the Play Store home page where the list contains different kinds of data objects (apps, movies, books) in a single list. 
<img src="https://github.com/shaishavgandhi05/sectioned-recyclerview/blob/master/images/play_store.jpeg" width="250px"/>

In such cases, maintaining a single underlying data source to the adapter becomes difficult and results in you having to write custom logic for when a certain type of data model appears, with it's custom binding, click listeners etc. 

In such cases, sectioned-recyclerview turns out to be an easy abstraction. 

## Usage

We'll recreate a Play Store like interface (slightly less polished, perhaps) with a list consisting of movies and books, like this :
<!--Insert Image Here -->



