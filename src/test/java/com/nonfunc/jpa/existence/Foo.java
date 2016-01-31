package com.nonfunc.jpa.existence;

/*
 * #%L
 * em
 * %%
 * Copyright (C) 2016 nonfunc.com
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="SelectMultipleItems", query="SELECT f FROM Foo f WHERE f.code > 30"),
	@NamedQuery(name="SelectCountOfItems", query="SELECT COUNT(f) FROM Foo f WHERE f.code > 30"),	
	@NamedQuery(name="Select1FromExact", query="SELECT 1 FROM Foo f WHERE f.code = 300"),
	@NamedQuery(name="SelectSingleItem", query="SELECT f FROM Foo f WHERE f.code = 300"),
	@NamedQuery(name="Select1FromMultiple", query="SELECT 1 FROM Foo f WHERE f.code > 30")
})
public class Foo {
	
	@Id
	long id;
	Long code;
	String description;
	
	@Column
	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	@Column
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
