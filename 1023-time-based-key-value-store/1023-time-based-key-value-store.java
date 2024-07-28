class TimeMap {

    HashMap<String, ArrayList<TimestampValue>> keyToTimeValue = new HashMap<>();

    public TimeMap() {
        keyToTimeValue = new HashMap<String, ArrayList<TimestampValue>>();
    }

    public void set(String key, String value, int timestamp) {
        ArrayList<TimestampValue> timeValues = keyToTimeValue.get(key);
        if (timeValues == null) {
            ArrayList<TimestampValue> newList = new ArrayList<>();
            keyToTimeValue.put(key, newList);
            timeValues = newList;
        }
        TimestampValue timevalue = new TimestampValue(timestamp, value);
        timeValues.add(timevalue);
    }

    public String get(String key, int timestamp) {
        String value = "";
        ArrayList<TimestampValue> timeValues = keyToTimeValue.get(key);
        if (timeValues != null) {
            int start = 0;
            int end = timeValues.size() - 1;
            while (start <= end) {
                int middle = (start + end) / 2;
                int middleTime = timeValues.get(middle).getTimestamp();
                if (middleTime > timestamp)
                    end = middle - 1;
                else {
                    value = timeValues.get(middle).getValue();
                    start = middle + 1;
                }
            }
        }

        return value;
    }

    class TimestampValue {
        int timestamp;
        String value;

        public TimestampValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }

        public int getTimestamp() {
            return timestamp;
        }

        public String getValue() {
            return value;
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */