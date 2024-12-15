<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ninja Gold</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script type="text/javascript" src="/js/script.js"></script>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="header">
        <div class="player-gold-container">
            <label for="player-gold">Your Gold:</label>
            <input type="text" id="player-gold" value="${gold}" class="default-cursor" readonly>
        </div>
        <div class="player-name-container">
            <form action="/play" method="post">
                <label for="player-name">Your Name:</label>
                <input type="text" id="player-name" value="${not empty name ? name : ''}" name="name" placeholder="Name.."
                    ${not empty name ? 'class="default-cursor" readonly' : ''}>
                <c:if test="${empty name}">
                    <button id="play" type="submit">Play</button>
                </c:if>
            </form>
        </div>
        <div class="player-gold-container">
            <label for="player-moves">Your Moves:</label>
            <input type="text" id="player-moves" value="${moves}" class="default-cursor" readonly>
        </div>
        <c:if test="${not empty name && not game}">
            <form action="/play_again" method="post">
                <button class="header-buttons" type="submit">Play Again</button>
            </form>
        </c:if>
        <a href="/view_scoreboard" target="_blank">
            <button class="header-buttons" type="button">View Scoreboard</button>
        </a>
    </div>
    <div class="game-over-container">
        <c:if test="${not empty name && not game}">
            <h4>Game Over - Out of moves</h4>
        </c:if>
    </div>
    <div class="game-mechanics">
        <div class="game-mechanic">
            <form action="/process_money" method="post">
                <h1>Farm</h1>
                <h2>(earns 5-20 golds)</h2>
                <input type="hidden" name="gold-min" value="5">
                <input type="hidden" name="gold-max" value="20">
                <input type="hidden" name="facility" value="Farm">
                <button type="submit" class="find-gold" ${empty name || !game ? 'disabled' : ''}>Find Gold!</button>
            </form>
        </div>
        <div class="game-mechanic">
            <form action="/process_money" method="post">
                <h1>Cave</h1>
                <h2>(earns 1-30 golds)</h2>
                <input type="hidden" name="gold-min" value="1">
                <input type="hidden" name="gold-max" value="30">
                <input type="hidden" name="facility" value="Cave">
                <button type="submit" class="find-gold" ${empty name || !game ? 'disabled' : ''}>Find Gold!</button>
            </form>
        </div>
        <div class="game-mechanic">
            <form action="/process_money" method="post">
                <h1>House</h1>
                <h2>(earns 10-15 golds)</h2>
                <input type="hidden" name="gold-min" value="10">
                <input type="hidden" name="gold-max" value="15">
                <input type="hidden" name="facility" value="House">
                <button type="submit" class="find-gold" ${empty name || !game ? 'disabled' : ''}>Find Gold!</button>
            </form>
        </div>
        <div class="game-mechanic">
            <form action="/process_money" method="post">
                <h1>Casino</h1>
                <h2>(earns/takes 0-50 golds)</h2>
                <input type="hidden" name="gold-min" value="-50">
                <input type="hidden" name="gold-max" value="50">
                <input type="hidden" name="facility" value="Casino">
                <button type="submit" class="find-gold" ${empty name || !game ? 'disabled' : ''}>Find Gold!</button>
            </form>
        </div>
    </div>
    <div class="activites-container">
        <h3>Activities:</h3>
        <div id="activities-log">
            <c:forEach var="activity" items="${activities}">
                <div class="bold ${activity.type == 'Earned' ? 'green-color' : activity.type == 'Lost' ? 'red-color' : ''}">
                    ${activity.message}
                </div>
            </c:forEach>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>