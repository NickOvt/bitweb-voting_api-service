package com.api.votingapi.models;

public class VoteResponse {
    private final String msg;

    public VoteResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
