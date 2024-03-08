package kr.co.seoulit.erp.account.posting.ledger.repository;

import kr.co.seoulit.erp.account.posting.ledger.entity.AssetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AssetRepository extends CrudRepository<AssetEntity, Integer> {

    @Override
    Iterable<AssetEntity> findAll();
}