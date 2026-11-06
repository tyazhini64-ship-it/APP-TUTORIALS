from automata.fa.dfa import DFA

dfa = DFA(
    states={'q0', 'q1', 'q2'},
    input_symbols={'0', '1'},
    transitions={
        'q0': {'0': 'q1', '1': 'q0'},
        'q1': {'0': 'q1', '1': 'q2'},
        'q2': {'0': 'q1', '1': 'q0'}
    },
    initial_state='q0',
    final_states={'q2'}
)

test_strings = ["101", "001", "110", "0101", "0"]
for s in test_strings:
    print(f"String '{s}' accepted:", dfa.accepts_input(s))