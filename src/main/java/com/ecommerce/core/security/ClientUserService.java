package com.ecommerce.core.security;

import com.ecommerce.core.entities.Client;
import com.ecommerce.core.exceptions.ClientNotFoundException;
import com.ecommerce.core.services.ClientService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gennt on 3/2/2017.
 */
public class ClientUserService implements UserDetailsService{

    private final ClientService clientService;

    public ClientUserService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Client client = clientService.findByUsername(s);

        GrantedAuthority authority = new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return client.getRole();
            }
        };

        if(client != null) {
            List<GrantedAuthority> authorities =
                    new ArrayList<>();
            authorities.add(authority);

            return new User(client.getUsername(), client.getPassword(), authorities);
        }
        throw new ClientNotFoundException();
    }
}
