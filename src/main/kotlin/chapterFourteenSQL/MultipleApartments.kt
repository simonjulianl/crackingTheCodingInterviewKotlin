package chapterFourteenSQL

/**
 * SELECT TName FROM Tenants, (
 *  SELECT TenandID FROM AptTenants GROUP BY TenantID HAVING count(*) > 1
 * ) C WHERE Tenants.TenantID = C.TenantID
 */

