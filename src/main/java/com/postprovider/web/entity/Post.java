//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.postprovider.web.entity;

import com.sun.istack.NotNull;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(
        collection = "Post"
)
public class Post implements Serializable {
    @Id
    @NotNull
    private String id;
    @NotBlank
    private String provider_id;
    private String name;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Post)) {
            return false;
        } else {
            Post post = (Post)o;
            return this.id.equals(post.id) && this.provider_id.equals(post.provider_id) && this.name.equals(post.name);
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProvider_id() {
        return this.provider_id;
    }

    public void setProvider_id(String provider_id) {
        this.provider_id = provider_id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post() {
    }

    public Post(String id, @NotBlank String provider_id, String name) {
        this.id = id;
        this.provider_id = provider_id;
        this.name = name;
    }
}
