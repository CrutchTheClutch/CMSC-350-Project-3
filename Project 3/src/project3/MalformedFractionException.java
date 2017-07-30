package project3;

/**
 * Filename:    MalformedFractionException
 * Author:      William Crutchfield
 * Date:        6/28/2017
 * Description: Handles the MalformedFractionException, is thrown when an incorrect fraction is used.
 */
class MalformedFractionException extends Exception{
    MalformedFractionException(String token) {
        super(token);
    }
}
