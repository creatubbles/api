package com.creatubbles.api.response.creator;

import lombok.Getter;
import lombok.ToString;

import com.creatubbles.api.APIVersion;
import com.creatubbles.api.core.CreatubblesResponse;
import com.creatubbles.api.core.User;
import com.creatubbles.api.response.ArrayResponse;
import com.google.gson.annotations.SerializedName;

@APIVersion(2)
@ArrayResponse
@Getter
@ToString(callSuper = true)
public class GetCreatorsResponse extends CreatubblesResponse {

    @SerializedName("attributes")
    User creator;
}
