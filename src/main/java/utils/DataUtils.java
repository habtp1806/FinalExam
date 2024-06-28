package utils;

import base.Config;
import enums.RailwayStation;
import enums.SeatType;
import model.BookTicket;
import model.User;
import org.testng.annotations.DataProvider;

public class DataUtils {

    @DataProvider(name = "bookTicketDataProvider")
    public static Object[][] bookTicketDataProvider() {
        return new Object[][]{
                {
                        new BookTicket(DateUtils.calculateNextDepartDate(9), RailwayStation.NHA_TRANG, RailwayStation.HUE, SeatType.SOFT_BED_AIR_CONDITIONER, "1")
                },
                {
                        new BookTicket(DateUtils.calculateNextDepartDate(10), RailwayStation.NHA_TRANG, RailwayStation.SAI_GON, SeatType.SOFT_SEAT_AIR_CONDITIONER, "1")
                },
                {
                        new BookTicket(DateUtils.calculateNextDepartDate(11), RailwayStation.NHA_TRANG, RailwayStation.SAI_GON, SeatType.SOFT_SEAT_AIR_CONDITIONER, "1")
                },
                {
                        new BookTicket(DateUtils.calculateNextDepartDate(12), RailwayStation.NHA_TRANG, RailwayStation.SAI_GON, SeatType.SOFT_SEAT_AIR_CONDITIONER, "1")
                },
                {
                        new BookTicket(DateUtils.calculateNextDepartDate(13), RailwayStation.NHA_TRANG, RailwayStation.SAI_GON, SeatType.SOFT_SEAT_AIR_CONDITIONER, "1")
                },
                {
                        new BookTicket(DateUtils.calculateNextDepartDate(14), RailwayStation.NHA_TRANG, RailwayStation.SAI_GON, SeatType.SOFT_SEAT_AIR_CONDITIONER, "1")
                },
        };
    }


}
