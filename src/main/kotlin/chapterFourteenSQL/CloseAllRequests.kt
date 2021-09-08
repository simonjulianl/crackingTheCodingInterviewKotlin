package chapterFourteenSQL

/**
 * UPDATE REQUESTS
 * SET status = 'closed'
 * WHERE Requests.AptId IN ( SELECT AptID FROM Apartments WHERE BuildingID = 11)
 */