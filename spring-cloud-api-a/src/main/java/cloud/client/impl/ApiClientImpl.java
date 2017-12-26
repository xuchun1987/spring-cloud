package cloud.client.impl;

import cloud.client.ApiClient;
import org.springframework.stereotype.Component;

@Component
public class ApiClientImpl implements ApiClient {


    public String handle(){

        return "error";
    }

    @Override
    public String usersList() {
        return handle();
    }
}
