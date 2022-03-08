package dto;
import java.util.Objects;

public class BookingDto {
    private int id;
    private int passenger_id;
    private String serial_number;

    public BookingDto() {
    }

    public BookingDto(int passenger_id, String serial_number) {
        this.passenger_id = passenger_id;
        this.serial_number = serial_number;
    }

    public BookingDto(int id, int passenger_id, String serial_number) {
        this.id = id;
        this.passenger_id = passenger_id;
        this.serial_number = serial_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassenger_id() {
        return passenger_id;
    }

    public void setPassenger_id(int passenger_id) {
        this.passenger_id = passenger_id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookingDto)) return false;
        BookingDto that = (BookingDto) o;
        return getId() == that.getId() && getPassenger_id() == that.getPassenger_id() && Objects.equals(getSerial_number(), that.getSerial_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPassenger_id(), getSerial_number());
    }

    @Override
    public String toString() {
        return "BookingDto{" +
                "id=" + id +
                ", passenger_id=" + passenger_id +
                ", serial_number='" + serial_number + '\'' +
                '}';
    }
}
