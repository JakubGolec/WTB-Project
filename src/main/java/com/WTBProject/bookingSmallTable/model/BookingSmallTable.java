package com.WTBProject.bookingSmallTable.model;
import com.WTBProject.bigTable.model.BigTable;
import com.WTBProject.game.model.Game;
import com.WTBProject.smallTable.model.SmallTable;
import com.WTBProject.user.model.User;

import javax.persistence.*;
import java.util.Date;

@Entity
public class BookingSmallTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private Date endDate;


    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    private SmallTable smallTable;

    @OneToOne(fetch = FetchType.LAZY)
    private Game game;




}
