package kr.co.seoulit.erp.account.posting.business.repository;

import kr.co.seoulit.erp.account.posting.business.entity.JournalDetailEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class JournalDetailRepository{

    @PersistenceContext
    EntityManager em;

    public void deleteByJournalNo(String journalNo) {
        em.createQuery("delete from JournalResEntity where journalNo = :journalNo")
                .setParameter("journalNo", journalNo).executeUpdate();
    }

    public void saveJournalDetail(JournalDetailEntity journalDetailEntity) {
        em.persist(journalDetailEntity);
    }

    public void saveJournalDetailList(JournalDetailEntity journalDetailEntity) {
        em.remove(journalDetailEntity);
    }

    public void removeJournalDetailByJournalNo(String journalNo) {
        em.createQuery("delete from JournalDetailResEntity where journalNo = :journalNo")
                .setParameter("journalNo", journalNo).executeUpdate();
    }

    public void mergeJournalDetail(JournalDetailEntity journalDetailEntity) {
        em.merge(journalDetailEntity);
    }
}
