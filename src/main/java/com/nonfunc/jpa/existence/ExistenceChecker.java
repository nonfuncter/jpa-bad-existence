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

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ExistenceChecker {

	EntityManager entityManager = null;

	public ExistenceChecker(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public boolean fastExistenceCheck() {
		Query query = entityManager.createNamedQuery("Select1FromMultiple");
		query.setMaxResults(1);
		return !query.getResultList().isEmpty();
	}

	public boolean fastExistenceCheckExact() {
		Query query = entityManager.createNamedQuery("Select1FromExact");
		query.setMaxResults(1);
		return !query.getResultList().isEmpty();
	}

	public boolean exists1() {
		Query query = entityManager.createNamedQuery("SelectMultipleItems");
		return query.getResultList().size() > 0;
	}

	public boolean exists2() {
		Query query = entityManager.createNamedQuery("SelectMultipleItems");
		return query.getResultList().size() >= 1;
	}

	public boolean exists3() {
		Query query = entityManager.createNamedQuery("SelectMultipleItems");
		return query.getResultList().size() < 1;
	}

	public boolean exists4() {
		Query query = entityManager.createNamedQuery("SelectMultipleItems");
		return query.getResultList().size() <= 0;
	}

	public boolean exists5() {
		Query query = entityManager.createNamedQuery("SelectMultipleItems");
		return query.getResultList().size() == 0;
	}

	public boolean exists6() {
		Query query = entityManager.createNamedQuery("SelectMultipleItems");
		return query.getResultList().size() != 0;
	}

	public boolean exists7() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getSingleResult() > 0;
	}

	public boolean exists8() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getSingleResult() >= 1;
	}

	public boolean exists9() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getSingleResult() < 1;
	}

	public boolean exists10() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getSingleResult() <= 0;
	}

	public boolean exists11() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getSingleResult() == 0;
	}

	public boolean exists12() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getSingleResult() != 0;
	}

	public boolean exists13() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getResultList().get(0) > 0;
	}

	public boolean exists14() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getResultList().get(0) >= 0;
	}

	public boolean exists15() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getResultList().get(0) < 1;
	}

	public boolean exists16() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getResultList().get(0) <= 0;
	}

	public boolean exists17() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getResultList().get(0) == 0;
	}

	public boolean exists18() {
		Query query = entityManager.createNamedQuery("SelectCountOfItems");
		return (Long) query.getResultList().get(0) != 0;
	}

	public boolean exists19() {
		Query query = entityManager.createNamedQuery("SelectMultipleItems");
		return query.getResultList().isEmpty();
	}

	public boolean exists20() {
		Query query = entityManager.createNamedQuery("SelectSingleItem");
		query.setMaxResults(1);
		return query.getSingleResult() == null;
	}

	public boolean exists21() {
		Query query = entityManager.createNamedQuery("SelectSingleItem");
		query.setMaxResults(1);
		return query.getSingleResult() != null;
	}

}