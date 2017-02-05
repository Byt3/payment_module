package com.shoparound.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StripeAuthResponse {

	/*
	 * {
  "access_token": "sk_test_sq4SMONBLRQIjPAf8n4HJyzg",
  "livemode": false,
  "refresh_token": "rt_A3XKpzfKlxczl57bakBEBH5pVra1neSOWLUerWVKB0qIjspg",
  "token_type": "bearer",
  "stripe_publishable_key": "pk_test_qM28cAUceoM5qGSmaGh6c0J4",
  "stripe_user_id": "acct_19jOxzIwPoRh0jpV",
  "scope": "read_write"
}
	 */
	
	@JsonProperty("access_token")
	private String accessToken;
	@JsonProperty("livemode")
	private Boolean liveMode;
	@JsonProperty("refresh_token")
	private String refreshToken;
	@JsonProperty("stripe_publishable_key")
	private String stripePublishableKey;
	@JsonProperty("stripe_user_id")
	private String stripeUserId;
	private String scope;
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Boolean getLiveMode() {
		return liveMode;
	}
	public void setLiveMode(Boolean liveMode) {
		this.liveMode = liveMode;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getStripePublishableKey() {
		return stripePublishableKey;
	}
	public void setStripePublishableKey(String stripePublishableKey) {
		this.stripePublishableKey = stripePublishableKey;
	}
	public String getStripeUserId() {
		return stripeUserId;
	}
	public void setStripeUserId(String stripeUserId) {
		this.stripeUserId = stripeUserId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	
	
	
}
