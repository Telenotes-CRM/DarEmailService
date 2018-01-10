package com.telenotes;

import com.telenotes.models.LinkedRepsMailbox;
import com.telenotes.models.Mailbox;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Urge_Smith on 1/5/18.
 */
public class DarDao extends TelenotesDbConnection {

    // For Singleton instantiation
    private static final Object LOCK = new Object();
    private static DarDao instance;

    public synchronized static DarDao getInstance() {
        if (instance == null) {
            synchronized (LOCK) {
                try {
                    instance = new DarDao();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    private DarDao() throws Exception {
        super();

    }

    public void getDars() {

        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            cstmt = dbConnection.prepareCall("{call dbo.sp_GetMailBoxIds}");
//            cstmt.setInt(1, 7498);
            rs = cstmt.executeQuery();

            List<Mailbox> mailboxes = new ArrayList<>();
            while (rs.next()) {
                Mailbox mailbox = new Mailbox();
                mailbox.mailboxId = rs.getInt(1);
                mailbox.firstName = rs.getString(2);
                mailboxes.add(mailbox);
            }

            System.out.println(mailboxes.get(0).firstName);

            if (mailboxes.size() > 0) {
                cstmt = dbConnection.prepareCall("{call dbo.sp_GetLinkedMailboxIds}");
                rs = cstmt.executeQuery();
                List<LinkedRepsMailbox> linkedReps = new ArrayList<>();
                while (rs.next()) {
                    LinkedRepsMailbox linkedRep = new LinkedRepsMailbox();
                    linkedRep.RepMailBox = rs.getInt(1);
                    linkedRep.firstname = rs.getString(2);
                    linkedRep.lastname = rs.getString(3);
                    linkedRep.clientid = rs.getInt(4);
                    linkedRep.DAROrder = rs.getLong(6);
                    linkedReps.add(linkedRep);
                }
                System.out.println(linkedReps.get(0).lastname);

                if (linkedReps.size() > 0) {
                    cstmt = dbConnection.prepareCall("{call dbo.sp_GetRepCallNotes}");
                    rs = cstmt.executeQuery();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
