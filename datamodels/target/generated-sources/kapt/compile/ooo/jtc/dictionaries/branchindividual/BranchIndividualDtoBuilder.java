package ooo.jtc.dictionaries.branchindividual;

import java.util.UUID;
import ooo.jtc.dictionaries.branch.BranchDto;
import ooo.jtc.dictionaries.individual.IndividualDto;

public final class BranchIndividualDtoBuilder {
  private UUID id;

  private int version;

  private UUID individualId;

  private UUID branchId;

  private BranchDto branch;

  private IndividualDto individual;

  public BranchIndividualDtoBuilder setId(UUID id) {
    this.id = id;
    return this;
  }

  public BranchIndividualDtoBuilder setVersion(int version) {
    this.version = version;
    return this;
  }

  public BranchIndividualDtoBuilder setIndividualId(UUID individualId) {
    this.individualId = individualId;
    return this;
  }

  public BranchIndividualDtoBuilder setBranchId(UUID branchId) {
    this.branchId = branchId;
    return this;
  }

  public BranchIndividualDtoBuilder setBranch(BranchDto branch) {
    this.branch = branch;
    return this;
  }

  public BranchIndividualDtoBuilder setIndividual(IndividualDto individual) {
    this.individual = individual;
    return this;
  }

  public BranchIndividualDto create() {
    return new BranchIndividualDto(id, version, individualId, branchId, branch, individual);
  }

  public static BranchIndividualDtoBuilder builder() {
    return new BranchIndividualDtoBuilder();
  }
}
