package com.example.eray.customlistview;
import java.util.ArrayList;

/**
 * Created by Karayel on 09.02.2016.
 */
public class Favourites {

    ArrayList<Author> favAuthors;

    public Favourites(){

    }

    /**
     * This method provides adding the favourite author
     * @param newFavouriteAuthor This is the first parameter to addToFavourites method
     * @return Nothing
     */
    public void addToFavourites(Author newFavouriteAuthor) {
        favAuthors.add(newFavouriteAuthor);
    }

    /**
     * This method provides deleting the favourite author
     * @param authorToDelete This is the first parameter to removeFromFavourites method
     * @return Nothing
     */
    public void removeFromFavourites(Author authorToDelete){
        favAuthors.remove(authorToDelete);
    }

    /**
     * This method provides deleting the favourite author with author's id
     * @param authorId This is the first parameter to removeFromFavouritesWithAuthorId method
     * @return Nothing
     */
    public void removeFromFavouritesWithAuthorId(int authorId){
        for(int i=0; i<this.favAuthors.size(); i++){
            if(this.favAuthors.get(i).getAuthorId() == authorId){
                this.favAuthors.remove(i);
            }
        }
    }

}
