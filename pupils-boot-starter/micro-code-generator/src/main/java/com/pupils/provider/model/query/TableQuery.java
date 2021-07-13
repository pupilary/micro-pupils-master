package com.pupils.provider.model.query;

import com.pupils.web.query.Query;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author takesi
 * @date 2021-07-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TableQuery extends Query {

    private String tableName;

}
