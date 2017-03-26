package fr.esilv.s8.afinal.models;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jean-Paul on 17/03/2017.
 */

public class Youtube {
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    //private JSONObject pageInfo;
    private ArrayList<Item> items;

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

  /*  public void setPageInfo(JSONObject pageInfo) {
        this.pageInfo = pageInfo;
    }*/

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public String getEtag() {
        return etag;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public String getRegionCode() {
        return regionCode;
    }

   /* public JSONObject getPageInfo() {
        return pageInfo;
    }*/

    public ArrayList<Item> getItems() {
        return items;
    }
}
