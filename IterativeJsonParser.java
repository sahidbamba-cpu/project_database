import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IterativeJsonParser extends JsonParser {

    protected IterativeJsonParser(String text) {
        super(text);
    }

    public static Object parse(String text) {
        return new IterativeJsonParser(text).parseDocument();
    }


    // TODO (README 8): bonus parseValue without recursion
    @Override
    protected Object parseValue() {
        skipWhitespace();

        char c = peek();

        // Scalar values don't require recursion
        if (c == '"') {
            return parseString();
        }

        if (c == '-' || isDigit(c)) {
            return parseNumber();
        }

        if (c == 't' || c == 'f' || c == 'n') {
            return parseLiteral();
        }

        if (c != '{' && c != '[') {
            throw error("Unexpected character '" + c + "'");
        }

        Deque<Object> containers = new ArrayDeque<>();
        Deque<String> keys = new ArrayDeque<>();

        Object root;

        if (c == '[') {
            expect('[');
            root = new ArrayList<Object>();
        } else {
            expect('{');
            root = new HashMap<String, Object>();
        }

        containers.push(root);

        while (!containers.isEmpty()) {
            skipWhitespace();

            Object current = containers.peek();

            // ARRAY
            if (current instanceof List) {
                List<Object> list = (List<Object>) current;

                if (peek() == ']') {
                    expect(']');
                    containers.pop();

                    if (containers.isEmpty()) {
                        return root;
                    }

                    skipWhitespace();

                    if (peek() == ',') {
                        expect(',');
                    }

                    continue;
                }

                char nextChar = peek();

                if (nextChar == '[') {
                    expect('[');

                    List<Object> child = new ArrayList<>();
                    list.add(child);
                    containers.push(child);

                } else if (nextChar == '{') {
                    expect('{');

                    Map<String, Object> child = new HashMap<>();
                    list.add(child);
                    containers.push(child);

                } else {
                    list.add(parseScalar());
                    skipWhitespace();

                    if (peek() == ',') {
                        expect(',');
                    } else if (peek() != ']') {
                        throw error("Expected ',' or ']'");
                    }
                }
            }

            // OBJECT
            else if (current instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) current;

                if (peek() == '}') {
                    expect('}');
                    containers.pop();

                    if (containers.isEmpty()) {
                        return root;
                    }

                    skipWhitespace();

                    if (peek() == ',') {
                        expect(',');
                    }

                    continue;
                }

                if (peek() != '"') {
                    throw error("Expected object key");
                }

                String key = parseString();

                skipWhitespace();
                expect(':');
                skipWhitespace();

                char nextChar = peek();

                if (nextChar == '[') {
                    expect('[');

                    List<Object> child = new ArrayList<>();
                    map.put(key, child);
                    containers.push(child);

                } else if (nextChar == '{') {
                    expect('{');

                    Map<String, Object> child = new HashMap<>();
                    map.put(key, child);
                    containers.push(child);

                } else {
                    map.put(key, parseScalar());

                    skipWhitespace();

                    if (peek() == ',') {
                        expect(',');
                    } else if (peek() != '}') {
                        throw error("Expected ',' or '}'");
                    }
                }
            }
        }

        return root;
    }

    private Object parseScalar() {
        skipWhitespace();

        char c = peek();

        if (c == '"') {
            return parseString();
        }

        if (c == '-' || isDigit(c)) {
            return parseNumber();
        }

        if (c == 't' || c == 'f' || c == 'n') {
            return parseLiteral();
        }

        throw error("Unexpected character '" + c + "'");
    }
}