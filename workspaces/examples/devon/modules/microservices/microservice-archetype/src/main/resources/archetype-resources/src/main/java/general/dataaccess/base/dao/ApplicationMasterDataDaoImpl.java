/*******************************************************************************
 * Copyright 2015-2018 Capgemini SE.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 ******************************************************************************/
#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.general.dataaccess.base.dao;

import java.util.List;

import io.oasp.module.jpa.dataaccess.api.MutablePersistenceEntity;
import io.oasp.module.jpa.dataaccess.api.RevisionedMasterDataDao;

/**
 * This is the abstract base implementation of {@link RevisionedMasterDataDao} based on {@link ApplicationDaoImpl}.
 *
 * @param <ENTITY> is the {@link ${symbol_pound}getEntityClass() type} of the managed entity.
 *
 */
public abstract class ApplicationMasterDataDaoImpl<ENTITY extends MutablePersistenceEntity<Long>>
    extends ApplicationDaoImpl<ENTITY> implements RevisionedMasterDataDao<ENTITY> {

  /**
   * The constructor.
   */
  public ApplicationMasterDataDaoImpl() {

    super();
  }

  @Override
  public List<ENTITY> findAll() {

    return super.findAll();
  }

}
