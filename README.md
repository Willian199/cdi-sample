# Biblioteca CDI no Quarkus

## Visão Geral

Este é um guia sobre Contexts and Dependency Injection (CDI) no Quarkus. Este README fornece informações essenciais para começar a usar a biblioteca em seu projeto Quarkus. A biblioteca ArC é baseada na especificação Jakarta Contexts and Dependency Injection 4.0. Ela implementa a especificação CDI Lite, com melhorias específicas.

Caso deseje testar o projeto em build nativa

Gere a build executando o `build-nativo.sh`

Com o docker instalado, rode o comando `docker compose -f docker-compose.yaml up`

O ambiente ficará disponivel na porta 8080.

## Uso Básico

O CDI utiliza anotações para injetar dependências e gerenciar o ciclo de vida dos objetos. Abaixo estão algumas das anotações mais comuns usadas:

#### @ApplicationScoped
Essa anotação marca uma classe como escopo de aplicação, o que significa que uma única instância será compartilhada por toda a aplicação. A instância é criada apenas quando um método é chamado pela primeira vez. No mais, comportamento similar ao `@Singleton`.

#### @Singleton
Esta anotação marca uma classe como escopo Singleton, o que significa que uma única instância será compartilhada por toda a aplicação. A instância é criada quando o **Bean** é injetado e não possui [client proxy](https://quarkus.io/guides/cdi#client_proxies).

#### @Dependent
Esta anotação marca uma classe como escopo Dependent, o que significa que uma nova instância será criada para cada injeção. Porém, seu tempo de vida será o mesmo da classe que está fazendo o `@Inject`. Pode resultar em vazamentos de memória.

#### @RequestScoped
Essa anotação marca uma classe como escopo de requisição, o que significa que uma nova instância será criada para cada requisição HTTP.

#### @SessionScoped
Essa anotação marca uma classe como escopo de sessão, o que significa que uma única instância será compartilhada por toda a sessão do usuário. Apenas disponível se usar a extensão [quarkus-undertow](https://quarkus.io/extensions/io.quarkus/quarkus-undertow).

#### @TransactionScoped
Essa anotação marca uma classe como escopo de Transação, compartilhando o mesmo contexto entre os **Beans** da transação atual. Apenas disponível se usar a extensão [quarkus-narayana-jta](https://quarkus.io/guides/transaction).

#### @Named
Use esta anotação para nomear um bean CDI para que ele possa ser referenciado ao fazer `@Inject`. O **Bean** não será removido, mesmo se não for usado.

#### @Vetoed
Esta anotação é usada para marcar uma classe que deve ser ignorada pelo CDI. Isso pode ser útil para evitar que uma classe seja considerada como um bean CDI.

#### @Inject
Use esta anotação para injetar uma dependência em um componente gerenciado pelo CDI.

#### @WithCaching
Permite realizar cache da instância do **Bean** que foi injetado na classe usando `@Inject`. Normalmente é usada ao fazer `@Inject` de um **Bean** `@Dependent`.



#### @Qualifier
Esta anotação é usada para criar qualificadores personalizados. Os qualificadores ajudam a diferenciar implementações de uma mesma interface que podem ser injetadas.

#### @Produces
Esta anotação é usada para criar e disponibilizar objetos gerenciados pelo CDI em um contexto. Você pode criar um método para produzir um objeto e torná-lo disponível para injeção.

#### @Disposes
Esta anotação é usada em conjunto com `@Produces` para marcar um método que é responsável por destruir uma instância criada por um método `@Produces`.

#### @Decorator
Anotação usada para criar decoradores que adicionam comportamento a um bean CDI. Os decoradores implementam interfaces que definem os métodos decorados.

#### @Interceptor
Use esta anotação para criar interceptadores CDI que podem ser usados para adicionar lógica adicional a métodos ou classes.

#### @AroundConstruct
Marca um método que será executado na classe de `@Interceptor`. Usada para adicionar lógica no momento em que o **Bean** for instanciado.

#### @AroundInvoke
Marca um método que será executado na classe de `@Interceptor`. Usada para adicionar lógica adicional antes ou após a execução do método.

#### @NoClassInterceptors
Ignora os `@Interceptor` definidos na classe, sendo executados apenas os que estão definidos diretamente no método ou construtor. Utilizada quando a classe possui um `@Interceptor` e o método possui outro `@Interceptor` com regra semelhante, ou quando não se deseja executar o `@Interceptor` da classe para o método em questão.

#### @Alternative
Esta anotação é usada para marcar uma implementação alternativa de um **Bean**. É útil para alterar o comportamento de **Bean** presente em alguma biblioteca de terceiros ou do próprio Quarkus.

#### @Specializes
Use esta anotação para criar uma classe que especializa outra classe, herdando seus métodos, campos e substituindo seu comportamento. Seu uso é para quando deseja um **Bean** totalmente novo. Semelhante ao `@Alternative`, porém mantém apenas esse **Bean**, sem instâncias alternativas.

#### @Priority
Permite definir a prioridade de um bean CDI em relação a outros beans do mesmo tipo. Isso é útil quando há vários beans compatíveis e você deseja especificar a ordem de seleção. Usada em conjunto com `@Alternative`, `@Decorator`, `@Interceptor`.

#### @Any
Esta anotação é usada para injetar qualquer **Bean** que corresponda ao tipo especificado, independentemente dos qualificadores.

#### @All
Esta anotação é usada para injetar todos os **Bean** que correspondam ao tipo especificado, independentemente dos qualificadores.

#### @Default
É o `@Qualifier` padrão para os **Bean** e `@Inject`. Sendo adicionado automaticamente quando nenhum outro `@Qualifier` foi usado.

#### @PostConstruct
Esta anotação é usada para marcar um método que deve ser executado após a criação de um bean CDI. É útil para realizar inicializações específicas do bean.

#### @PreDestroy
Marca um método que será executado antes que um bean CDI seja destruído. Isso é útil para realizar ações de limpeza ou liberação de recursos.

#### @Observes/@ObservesAsync
Esta anotação é usada para criar métodos observadores que reagem a eventos CDI. Os métodos marcados com `@Observes` podem ser acionados quando ocorrerem eventos específicos.

#### @Startup
Marca um bean para ser inicializado juntamente com o servidor. Porém, é recomendado criar um método usando `@Observes StartupEvent event`.

#### @Shutdown
Marca um bean para ser executado no momento em que o servidor será parado/desativado. Disponível a partir do **Quarkus 3.5**. Porém, é recomendado criar um método usando `@Observes ShutdownEvent event`.

#### @ActivateRequestContext
Possibilita adicionar o contexto de requisição em um método ou classe que não possui contexto. Por exemplo, em threads que precisam realizar consultas.

#### @Unremovable
Usada para marcar um **Bean** como "não removível". Isso significa que o **Bean** não será removido da aplicação, mesmo se não for usado explicitamente.

#### @IfBuildProfile/@UnlessBuildProfile
Permite criar um **Bean** somente para os profiles desejados. Necessário utilizar também `@DefaultBean`, definindo um **Bean** para os outros profiles que não atendem à condição. Normalmente utilizada em métodos juntamente com `@Produces`.

#### @IfBuildProperty/@UnlessBuildProperty
Permite criar um **Bean** baseado em uma propriedade definida no arquivo de configuração ou variável de ambiente. Necessário utilizar também `@DefaultBean`, definindo um **Bean** para quando a propriedade não atender à condição. Normalmente utilizada em métodos juntamente com `@Produces`.

#### @LookupIfProperty/@LookupUnlessProperty
Utilizado para fazer o `@Inject` de um **Bean** baseado no arquivo de configuração ou variável de ambiente. Usado em classes quando não possui `@Qualifier` para escolher qual **Bean** será injetado.

#### @ConfigProperty
Usada para injetar valores de configuração definidos em arquivos de propriedades ou variáveis de ambiente. Isso permite que você configure beans com propriedades externas.

#### @Lock
Usado para definir o funcionamento do acesso concorrente ao **Bean**. Normalmente utilizado juntamente com `@ApplicationScoped` e `@Singleton`.

#### @DefaultBean (Arc/Quarkus)
Declara um bean “padrão” que pode ser substituído por outro bean com a mesma tipagem/qualificadores. Facilita overrides específicos por profile/módulo sem necessidade de `beans.xml`.

#### @Stereotype
Meta‑anotação para agrupar várias anotações (escopo, qualifiers, interceptors) em uma única anotação reutilizável, padronizando a configuração de beans.

#### @Initialized/@Destroyed (+ @Observes)
Permite observar o ciclo de vida de escopos (application, request, session, etc.) para executar inicializações e limpezas em momentos específicos. Útil para warm-up de caches, abertura/fechamento de recursos e tarefas de limpeza atreladas ao início e fim do contexto. A escolha do escopo observado determina quando os callbacks são disparados (por exemplo, início/fim da aplicação ou de cada requisição).

#### Instance\<T>/Provider\<T> com @Any
Habilita lookup programático e seleção dinâmica de beans em tempo de execução, favorecendo padrões como estratégia e plugins. Permite iterar todos os beans de um tipo, selecionar por qualifiers em tempo de execução e adiar a criação de instâncias quando necessário.

- Ao usar Instance\<T>, permite selecionar um **Bean** dinâmicamente, sendo possivel 
usar uma constante, um parâmetro do frontend ou alguma variavel de ambiente.

Observação: ao obter instâncias programaticamente (ex.: via `Instance<T>`), se a API fornecer um handle/controle de ciclo de vida, finalize-o (ex.: `destroy()`) para evitar vazamentos de memória.

## ARC

#### Arc.container(): lookups estáticos (sem @Inject)
APIs estáticas do Arc permitem obter beans programaticamente sem `@Inject`. Útil para integrações, utilitários ou pontos onde a injeção não é possível.

#### Lookup por nome (String)
Use quando o bean possui nome (por exemplo, anotado com `@Named("meuBean")`).

```java
import io.quarkus.arc.Arc;
import io.quarkus.arc.InstanceHandle;

InstanceHandle<Object> handle = Arc.container().instance("Nome_da_instancia_String");
if (handle.isAvailable()) {
    Object bean = handle.get();
    // uso do bean
}
```

#### Lookup por tipo
Forma mais segura para refactors do que usar nomes.

```java
import io.quarkus.arc.Arc;
import io.quarkus.arc.InstanceHandle;

InstanceHandle<MyService> handle = Arc.container().instance(MyService.class);
MyService myService = handle.get();
```

#### Lookup por tipo + qualifier
Permite selecionar uma implementação específica via qualifier literal.

```java
import io.quarkus.arc.Arc;
import io.quarkus.arc.InstanceHandle;
import jakarta.enterprise.util.AnnotationLiteral;

@interface Credit {}

class CreditLiteral extends AnnotationLiteral<Credit> implements Credit {
    private static final long serialVersionUID = 1L;
}

InstanceHandle<PaymentService> creditSvc = Arc.container().instance(PaymentService.class, new CreditLiteral());
PaymentService svc = creditSvc.get();
```

#### InstanceHandle: disponibilidade e destruição
Ao obter via `Arc.container().instance(...)`, você recebe um `InstanceHandle<T>`, que permite verificar disponibilidade e destruir corretamente a instância.

```java
InstanceHandle<PaymentService> handle = Arc.container().instance(PaymentService.class);
if (handle.isAvailable()) {
    try {
        handle.get().process(100.0);
    } finally {
        handle.destroy(); // encerra instâncias contextuais quando aplicável
    }
}
```

Observação: sempre que usar `InstanceHandle`, prefira o padrão try/finally para garantir a chamada de `destroy()` e evitar vazamentos de memória, especialmente com escopos contextuais.

#### Ativar contexto de requisição programaticamente
Útil em threads onde o contexto de requisição não está ativo.

```java
var requestCtx = Arc.container().requestContext();
if (!requestCtx.isActive()) {
    requestCtx.activate();
    try {
        // chamadas que dependem de @RequestScoped aqui
    } finally {
        requestCtx.terminate();
    }
}
```

