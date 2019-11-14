package com.mcalzada.controller.not_found;

/**
 * {@link UserNotFoundException}
 *
 * @author MarcoCalzada
 * @version 1
 * @since MarcoCalzada
 */
public class UserNotFoundException extends RuntimeException
{
    public UserNotFoundException(Long id)
    {
        super("Could not find employee " + id);
    }
}
