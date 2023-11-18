/*
 * Copyright (c) 2023.
 * Created this for the project called "TheJackFolio"
 * All right reserved by Jack
 */

package com.thejackfolio.microservices.thejackfolio_db.servicehelpers;

import com.thejackfolio.microservices.thejackfolio_db.entities.Games;
import com.thejackfolio.microservices.thejackfolio_db.entities.InterestedGames;
import com.thejackfolio.microservices.thejackfolio_db.exceptions.DataBaseOperationException;
import com.thejackfolio.microservices.thejackfolio_db.repositories.GamesRepository;
import com.thejackfolio.microservices.thejackfolio_db.repositories.InterestedGamesRepository;
import com.thejackfolio.microservices.thejackfolio_db.utilities.StringConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameServiceHelper.class);

    @Autowired
    private GamesRepository repository;
    @Autowired
    private InterestedGamesRepository interestedGamesRepository;

    public void saveGame(Games games) throws DataBaseOperationException {
        try {
            repository.save(games);
        } catch (Exception exception) {
            LOGGER.info(StringConstants.DATABASE_ERROR, exception);
            throw new DataBaseOperationException(StringConstants.DATABASE_ERROR, exception);
        }
    }

    public void saveInterestedGames(List<InterestedGames> games) throws DataBaseOperationException {
        try {
            interestedGamesRepository.saveAll(games);
        } catch (Exception exception) {
            LOGGER.info(StringConstants.DATABASE_ERROR, exception);
            throw new DataBaseOperationException(StringConstants.DATABASE_ERROR, exception);
        }
    }
}
