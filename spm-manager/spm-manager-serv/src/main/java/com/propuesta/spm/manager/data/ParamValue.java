
package com.propuesta.spm.manager.data;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author spm
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class ParamValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlElement
    private Long value;
    @XmlElement
    private String description;

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
