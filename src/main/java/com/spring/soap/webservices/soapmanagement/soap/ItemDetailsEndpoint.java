package com.spring.soap.webservices.soapmanagement.soap;

import java.util.List;

import com.spring.soap.webservices.soapmanagement.soap.bean.Item;
import com.spring.soap.webservices.soapmanagement.soap.service.ItemDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import soap_management.items.GetAllItemsRequest;
import soap_management.items.GetAllItemsResponse;
import soap_management.items.GetItemDetailsRequest;
import soap_management.items.GetItemDetailsResponse;
import soap_management.items.ItemDetails;

@Endpoint
public class ItemDetailsEndpoint {

    @Autowired
    ItemDetailsService service;

    //based on item-details.xsd
    //namespace -> xmlns:tns http://soap-management/items
    //xs:element GetItemDetailsRequest
    @PayloadRoot(namespace="http://soap-management/items", localPart="GetItemDetailsRequest")
    @ResponsePayload
    public GetItemDetailsResponse proccessItemDetailsResponse(@RequestPayload GetItemDetailsRequest request) {
        GetItemDetailsResponse response = new GetItemDetailsResponse();
        Item item = service.findById(request.getId());
        if(item==null) {
            throw new RuntimeException("Invalid item id: " + request.getId());
        }
        
        response.setItemDetails(mapItem(item));
        return response;        
    }

    private ItemDetails mapItem(Item item) {
        ItemDetails itemDetails = new ItemDetails();
        itemDetails.setId(item.getId());
        itemDetails.setName(item.getName());
        itemDetails.setDescription(item.getDescription());
        return itemDetails;
    }

    //another endpoint created from new request and response in xsd
    @PayloadRoot(namespace="http://soap-management/items", localPart="GetAllItemsRequest")
    @ResponsePayload
    public GetAllItemsResponse proccessAll(@RequestPayload GetAllItemsRequest request) {
        List<Item> items = service.findAll();
        return mapItems(items);        
    }

    private GetAllItemsResponse mapItems(List<Item> items) {
        GetAllItemsResponse response = new GetAllItemsResponse();
        for(Item item: items) {
            ItemDetails details = mapItem(item);
            response.getItemDetails().add(details);
        }
        return response;
    }

    
}