import java.util.Stack;

class Historico {
    private Stack<Memento> pilha = new Stack<>();

    public void salvar(Memento m) {
        pilha.push(m);
    }

    public Memento desfazer() {
        if (!pilha.isEmpty()) {
            return pilha.pop();
        }
        return null;
    }

    public boolean temEstados() {
        return !pilha.isEmpty();
    }
}
