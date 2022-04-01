package com.aksahyaap.panditbook.model;

import com.google.gson.annotations.SerializedName;


public class ProposalRequest {
    @SerializedName("proposal")
    Proposal proposal;
    @SerializedName("user")
    private User user;

    public ProposalRequest() {
    }

    public ProposalRequest(User user, Proposal proposal) {
        this.user = user;
        this.proposal = proposal;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Proposal getProposal() {
        return proposal;
    }

    public void setProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    @Override
    public String toString() {
        return "ProposalRequest{" +
                "user=" + user +
                ", proposal=" + proposal +
                '}';
    }
}
