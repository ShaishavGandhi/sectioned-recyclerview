# Sectioned-RecyclerView
RecyclerView with support for sections, headers and adding miscellaneous views at any position.

## Use Case
There are often times when lists to display have complex underlying data beneath them. Take an example of the Play Store home page where the list contains different kinds of data objects (apps, movies, books) in a single list. 
![alt tag]()
In such cases, maintaining a single underlying data source to the adapter becomes impossible and results in you having to write custom logic for when a certain type of data model appears, with it's custom binding, click listeners etc. 

In such cases, sectioned-recyclerview turns out to be an easy abstraction. 
