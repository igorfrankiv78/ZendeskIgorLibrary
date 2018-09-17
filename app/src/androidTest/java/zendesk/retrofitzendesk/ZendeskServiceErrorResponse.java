package zendesk.retrofitzendesk;

import java.util.HashMap;
import java.util.Map;

public class ZendeskServiceErrorResponse {

    private Error error;

    private Map<String, Object> additionalProperties = new HashMap<>();

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}