package com.ecommerce.rest.util;

import com.ecommerce.core.entities.Client;
import com.ecommerce.rest.resources.ClientResource;
import com.ecommerce.rest.resources.asm.ClientResourceAsm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gennt on 3/2/2017.
 */
public class ClientList {

    private ArrayList<ClientResource> clientResources;

    public ClientList() {
        this.clientResources = new ArrayList<>();
    }

    public ArrayList<ClientResource> getClientResources() {
        return clientResources;
    }

    public void setClientResources(ArrayList<ClientResource> clientResources) {
        this.clientResources = clientResources;
    }

    public void clientToResource(List<Client> clients){
        for (Client c : clients) {
            clientResources.add(new ClientResourceAsm().toResource(c));
        }
    }
}
