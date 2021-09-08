package chapterFourteenSQL

/**
 * SELECT BName, ISNULL(Count, 0) as 'Count'
 * FROM Buildings
 * LEFT JOIN (
 *  SELECT Apartments.BuildingID, count(*) as 'Count'
 *  FROM Requests, Apartments
 *  WHERE Requests.AptID = Apartments.AptID AND Requests.Status = "Open"
 *  GROUP BY Apartments.BuildingID
 * ) C ON C.BuildingID = Buildings.BuildingID
 */